(ns reframe.routes
    (:require-macros [secretary.core :refer [defroute]])
    (:import goog.History)
    (:require [secretary.core :as secretary]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              [re-frame.core :as re-frame]
              [reframe.db :as db]))

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")
  (let [pages (keys (:pages db/default-db))]
    (doseq [page pages]
      (defroute (get-in db/default-db [:pages page :url]) []
        (re-frame/dispatch [:pages-set-active page]))))
  (hook-browser-navigation!))
