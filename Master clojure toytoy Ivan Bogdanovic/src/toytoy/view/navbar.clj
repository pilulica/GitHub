(ns toytoy.view.navbar
  (:require [compojure.core :refer :all]
            [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [hiccup.bootstrap.page :refer :all]
            ))


(defn nav []
  [:nav {:class "navbar navbar-expand-lg navbar-light bg-light"}
   [:a {:class "navbar-brand" :href "/"} "ToyToy"]
   [:button {:type "button" :class "navbar-toggler" :data-toggle "collapse"
             :data-target "#navbarNavDropdown" :aria-expanded "false" :aria-controls "navbarNavDropdown"
             :aria-label "Toggle navigation"}
    [:span {:class "navbar-toggler-icon"}]]
   [:div {:class "collapse navbar-collapse" :id "navbarNavDropdown"}
    [:ul {:class "navbar-nav"}
     [:li {:class "nav-item dropdown"}
      [:a {:class "nav-link dropdown-toggle" :href "/" :id "navbarDropdownMenuLink" :data-toggle "dropdown" :aria-hashpopup "true" :aria-expanded "false"} "Toys"]
      [:div {:class "dropdown-menu" :aria-labelledby "navbarDropdownMenuLink"}
       [:a {:class "dropdown-item" :href "/listOfToys"} "List Of Toys"]
       [:a {:class "dropdown-item" :href "/add"} "Add New Toy"]
       [:a {:class "dropdown-item" :href "/delete"} "Delete Toys"]
       ]
      ]
     [:li {:class "nav-item dropdown"}
      [:a {:class "nav-link dropdown-toggle" :href "/" :id "navbarDropdownMenuLink" :data-toggle "dropdown" :aria-hashpopup "true" :aria-expanded "false"} "Picture Of Toys"]]
]
    ]])