(ns reframe.db
    (:require [re-frame.core :as re-frame]))

(def default-db
  {:name "ReFrame"
   :pages {:home  {:label "Home"  :url "/" }
           :tasks {:label "Tasks" :url "/tasks" }}
   :auth {:client-id "CKGG9bWf1UJvwTrU0Ya8V8tUCN7vK27C"
          :domain "eauc.eu.auth0.com"}})

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   default-db))
