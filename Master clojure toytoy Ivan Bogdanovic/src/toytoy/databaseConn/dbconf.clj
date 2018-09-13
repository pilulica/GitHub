(ns toytoy.databaseConn.dbconf
  (:require [clojure.java.jdbc :as sql]))

(let [db-host "localhost"
      db-port 3306
      db-name "toytoy"]

  (def toytoy {:classname "com.mysql.jdbc.Driver"
           :subprotocol "mysql"
           :subname (str "//" db-host ":" db-port "/" db-name)
           :user "root"
           :password ""}))

(defn read-table []
  (sql/with-connection
    toytoy
    (sql/with-query-results res
                            ["SELECT * FROM toys ORDER BY toyid ASC"]
                            (doall res))))


(defn save [toyname toytype toyprice toynumbers toyav]
  (sql/with-connection
    toytoy
    (sql/insert-values
      :toys
      [:toyname :toytype :toyprice :toynumbers :toyav]
      [toyname toytype toyprice toynumbers toyav])))

(defn find [toyid]
  (first
    (sql/with-connection
      toytoy
      (sql/with-query-results res
                              ["SELECT * FROM toys WHERE toyid= ?" toyid]
                              (doall res)))))

(defn delete [toyid]
  (sql/with-connection
    toytoy
    (sql/delete-rows
      :toys
      ["toyid=?" toyid])))

(defn update [toyid toyprice toynumbers toyav]
  (sql/with-connection
    toytoy
    (sql/update-values
      :toys
      ["toyid=?" toyid]
      {:toyprice toyprice :toynumbers toynumbers :toyav toyav})))

(defn search [toyname]
  (first
    (sql/with-connection
      toytoy
      (sql/with-query-results res
                              ["SELECT * FROM toys WHERE toyname CONTAINS ?" toyname]
                              (doall res)))))