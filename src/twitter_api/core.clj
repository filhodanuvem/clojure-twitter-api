(ns twitter-api.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json])
  (:gen-class))

(defn hello-world
  "index route"
  [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello World"})

(defroutes app-routes
           (GET "/" [] hello-world))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [port 3000]
    (server/run-server #'app-routes {:port port})
    (println (str "Running service on port " port ))))
