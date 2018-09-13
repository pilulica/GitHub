(ns toytoy.view.layout
  (:require [hiccup.page :refer :all]))

(defn common [& body]
  (html5
    [:head
     [:title "ToyToy"]
     (include-css "/css/toytoy.css")
     (include-js "/js/validation.js")]
    [:body
     [:div {:class "container"}
      body
      ]
     ]))