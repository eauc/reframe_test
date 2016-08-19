(ns reframe.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [devtools.core :as devtools]
              [reframe.routes :as routes]
              [reframe.components.app :as app]
              [reframe.config :as config])
    (:require-macros [devcards.core :refer [defcard defcard-rg]]))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")
    (devtools/install!)))

(defn mount-root []
  (reagent/render [app/view]
                  (.getElementById js/document "app")))

(defcard-rg my-first-card "## Example markdown"
  (fn [_ _]
    [:p "This is shit"]))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (if (not config/debug?)
    (. js/window (offlineRegisterWorker)))
  (mount-root))
