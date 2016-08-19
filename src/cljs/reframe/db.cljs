(ns reframe.db
  (:require [re-frame.core :as re-frame])
  (:require-macros [reframe.env :refer [cljs-env]]))

(def default-db
  {:name "ReFrame"
   :pages {:home  {:label "Home"  :url "/" }
           :tasks {:label "Tasks" :url "/tasks" }}
   :auth {:client-id (cljs-env :auth-client-id)
          :domain (cljs-env :auth-domain)}
   :tasks {:url (cljs-env :tasks-url)}})

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   default-db))
