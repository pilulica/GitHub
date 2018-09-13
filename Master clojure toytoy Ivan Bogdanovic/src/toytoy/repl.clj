(ns toytoy.repl
  (:use toytoy.handler
        ring.server.standalone
        [ring.middleware file-info file]))

(defonce server (atom nil))

(defn get-handler []
  (-> #'app
      (wrap-file "resources")
      (wrap-file-info)))



(defn stop-server []
  (.stop @server)
  (reset! server nil))


(defn start-server
  "used for starting the server in development mode from REPL"
  [& [port]]
  (let [port (if port (Integer/parseInt port) 8080)]
    (reset! server
            (serve (get-handler)
                   {:port port
                    :auto-reload? true
                    :join true}))
    (println (str "http://localhost:" port))))
;(stop-server)
(start-server)