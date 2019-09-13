(ns toytoy.view.layout
  (:require [hiccup.page :refer :all]
            [toytoy.view.navbar :as navbar]))

(defn common [& body]
  (html5
    (navbar/nav)
    [:head
     [:title "ToyToy"]
     (include-js "https://code.jquery.com/jquery-3.2.1.slim.min.js")
     (include-js "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js")
     (include-js "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js")
     (include-css "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css")
     (include-css "/css/toytoy.css")
     (include-js "/js/validation.js")]
    [:body
     [:div {:class "container"}
      body
      ]
     ]))