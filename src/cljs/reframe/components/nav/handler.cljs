(ns reframe.components.nav.handler
    (:require [re-frame.core :as re-frame]))

(re-frame/register-handler
 :nav-toggle
 (fn [db [_]]
   (update-in db [:nav :show] not)))
