(ns twitter-api.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [ring.middleware.json :as ring-mid-json]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [twitter-api.tweets.validation :as v])
  (:gen-class))


(defn add-tweets
  "index route"
  [req]
  (let [is-valid
        (v/validate-tweet (:body req))]
    {:status  (if (true? is-valid) 200 400)
     :headers {"Content-Type" "text/html"}
     :body    (if
                (true? is-valid)
                "salvou"
                "nao salvou")}))
(defroutes app
           (ring-mid-json/wrap-json-body (POST "/tweets" [] add-tweets)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [port 3000]
    (server/run-server #'app {:port port})
    (println (str "Running service on port " port ))))
