(ns reframe.components.menu.handler
    (:require [re-frame.core :as re-frame]))

(re-frame/register-handler
 :menu-toggle
 (fn [db [_]]
   (update-in db [:menu :show] not)))
