(defproject project "0.8.13-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [hiccup-table "0.2.0"]
                 [ring-server "0.3.1"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [mysql/mysql-connector-java "5.1.18"]]
  :plugins [[lein-ring "0.8.12"]]
  :ring {:handler toytoy.handler/app}
  :profiles
  {:uberjar {:aot :all}
   :production
            {:ring
             {:open-browser? true, :stacktraces? true, :auto-reload? false}}
   :dev
            {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})