(ns toytoy.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [toytoy.databaseConn.dbconf :as toytoydb]
            [toytoy.home.home :refer [home-home]]))

(defroutes app-routes
           (route/resources "/")
           (route/not-found "Page not found!"))

(def app
  (-> (routes home-home app-routes)
      (handler/site)
      (wrap-base-url)))