(ns toytoy.home.home
  (:require [compojure.core :refer :all]
                              [toytoy.view.layout :as layout]
                              [toytoy.databaseConn.dbconf :as toytoydb]
                              [clojure.string :as str]
                              [hiccup.form :refer :all]
                              [hiccup.core :refer [h]]
                              [hiccup.page :as page]
                              [ring.util.response :as ring]))

(defn convert-answer [answer]
  (if (= answer true) "yes" "no"))

(defn show-all []
  [:table {:class "table table-striped"}
   [:thead
    [:tr {:class "table tr"}
     [:th "Toy"]
     [:th "Type"]
     [:th "Price"]
     [:th "Number of sold toys"]
     [:th "Available"]]]
   (into [:tbody ]
         (for [toy (toytoydb/read-table)]
           [:tr {:class "table tr"}
            [:td {:style "font-style: italic" }(:toyname toy)]
            [:td (:toytype toy )]
            [:td (:toyprice toy) "  RSD"]
            [:td (:toynumbers toy)]
            [:td (convert-answer (:toyav toy))]
            [:td {:style "border-bottom: 0px"} [:a {:class "btn btn-primary" :href (str "/updateButton/" (h (:toyid toy)))} "Update"]]]))])

(defn delete-page []
  (layout/common
    [:br]
    [:h1 "Delete Toy"]
    [:br]
  [:table {:class "table-main"}
   [:thead
    [:tr
     [:th "Toy"]
     [:th "Type"]
     [:th "Price"]
     [:th "Number of sold toys"]
     [:th "Available"]]]
   (into [:tbody]
         (for [toy (toytoydb/read-table)]
           [:tr
            [:td {:style "font-style: italic"}(:toyname toy)]
            [:td (:toytype toy )]
            [:td (:toyprice toy) "  RSD"]
            [:td (:toynumbers toy)]
            [:td (convert-answer (:toyav toy))]
            [:td {:style "border-bottom: 0px"} [:a {:class "button-add" :href (str "/delete/" (h (:toyid toy)))} "Delete"]]]))]))
(defn indexpage []
  (layout/common
    ;index page describe
    ))


(defn insert_or_update [& [toyid toyname toytype toyprice toynumbers toyav]]
  (layout/common
    [:h2 {:class "details-title"} (if (nil? toyid) "Add new toy:" "Update toy:")]
    (form-to {:toyid "frm"}
             [:post "/save"]

             [:table {:class "table-details"}
              [:tr {:style "display: none"}
               [:td "ToyId"]
               [:td (if (not (nil? toyid))
                      (text-field {:readonly true :class "text-form"} "toyid" toyid))]
               ]
              [:tr
               [:td "ToyName"]
               [:td (if (not (nil? toyid))
                      (text-field {:readonly true :class "text-form"} "toyname" toyname)
                      (text-field {:class "text-form"} "toyname" toyname))]
               ]
              [:tr
               [:td "ToyType"]
               [:td (if (not (nil? toyid))
                      (text-field {:readonly true :class "text-form"} "toytype" toytype)
                      (text-field {:class "text-form"} "toytype" toytype))]
               ]
              [:tr
               [:td "ToyPrice"]
               [:td (text-field {:toyid "toyprice" :class "text-form"} "toyprice" toyprice)]
               ]
              [:tr
               [:td "Number of sold toys"]
               [:td (text-field {:class "text-form"} "toynumbers" toynumbers)]
               ]
              [:tr
               [:td "Available"]
               [:td (check-box {:class "text-form"} "toyav" toyav)]
               ]
              ]
             (submit-button {:onclick "return validate()"} (if (nil? toyid)"Save" "Update"))
             "&nbsp&nbsp"
             [:hr])
    [:a {:href "/" :class "button-add move-right" :style "float: left"} "Home"]
    ))

(defn show-toy [toy]
  (insert_or_update (:toyid toy) (:toyname toy) (:toytype toy) (:toyprice toy) (:toynumbers toy) (:toyav toy)))

(defn convert-boolean [arg]
  (if (= arg "true") 1 0))

(defn save [toyname toytype toyprice toynumbers toyav &[toyid]]
  (if (not (nil? toyid))
    (toytoydb/update toyid toyprice toynumbers (convert-boolean toyav))
    (toytoydb/save toyname toytype toyprice toynumbers (convert-boolean toyav)))
  (ring/redirect "/"))

(defn delete [toyid]
  (if (not (= toyid 0))
    (toytoydb/delete toyid))
  (ring/redirect "/delete"))

(defn listOfToys []
  (layout/common
      [:h1 {:class "title"}
       " ToyToy "]
      [:h2 {:class "title-second"}
       "List of toys:"]
      [:br]
      [:br]
     (show-all)
    ))

(defroutes home-home
           (GET "/" [](indexpage))
           (GET "/updateButton/:toyid" [toyid] (show-toy (toytoydb/find toyid)))
           (GET "/add" [](insert_or_update))
           (POST "/save" [toyname toytype toyprice toynumbers toyav toyid](save toyname toytype toyprice toynumbers toyav toyid))
           (GET "/delete/:toyid" [toyid](delete toyid))
           (GET "/listOfToys" [] (listOfToys))
           (GET "/delete" [] (delete-page)))