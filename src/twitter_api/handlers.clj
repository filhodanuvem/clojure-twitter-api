(ns twitter-api.handlers
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [clojure.tools.logging :as log]
            [twitter-api.tweets.database :as d])
  (:gen-class))

(defn post-twitter-handler
  [req]
  (log/info req)
    (let [saved (try
                  (d/post-tweet (:body req))
                  (catch Exception e
                    (do
                      (log/error (.getMessage e))
                      false)))]
      {:status  (if (true? saved) 200 400)
      :headers {"Content-Type" "text/html"}
      :body    (if
                  (false? saved)
                  "error or saving tweet")}))