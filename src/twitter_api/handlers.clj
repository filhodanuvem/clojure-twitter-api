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
    (let [tweet-json (:body req)
          saved (try
                  (d/post-tweet tweet-json)
                  (catch Exception e
                    (do
                      (log/error e)
                      false)))]
      (log/info tweet-json)
      {:status  (if (true? saved) 200 400)
      :headers {"Content-Type" "text/html"}
      :body    (when (false? saved)
                  "error or saving tweet")}))

(defn get-twitter-handler
  [{{:keys [username]} :params}]
    (let
      [tweets (d/search-tweets-by-username username)]
      {:status 200
      :headers {"Content-type" "application/json"}
      :body tweets}))