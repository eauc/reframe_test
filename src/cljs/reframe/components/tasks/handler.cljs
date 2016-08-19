(ns reframe.components.tasks.handler
  (:require [clojure.walk :refer [keywordize-keys]]
            [re-frame.core :as re-frame]
            [ajax.core :refer [GET POST PUT DELETE]]))

(re-frame/register-handler
 :tasks-init
 (fn [db [_]]
   (let [tasks-url (get-in db [:tasks :url])
         auth-token (get-in db [:auth :token])]
     (GET tasks-url
          {:format :json :keywords? true
           :headers {:Authorization (str "Bearer " auth-token)}
           :handler #(re-frame/dispatch [:tasks-set %])
           :error-handler #(println "error" %)})
     db)))

(re-frame/register-handler
 :tasks-set
 (fn [db [_ tasks]]
   (assoc-in db [:tasks :data] (mapv keywordize-keys tasks))))

(re-frame/register-handler
 :tasks-create
 (fn [db [_]]
   (let [new-task {:title (get-in db [:tasks :create :title])
                   :id (. js/Date (now))}
         tasks-url (get-in db [:tasks :url])
         auth-token (get-in db [:auth :token])]
     (POST tasks-url
           {:format :json :keywords? true
            :params new-task
            :headers {:Authorization (str "Bearer " auth-token)}
            :handler #(re-frame/dispatch [:tasks-init])
            :error-handler #(println "error" %)})
     (update-in db [:tasks :data] #(into % [new-task])))))

(re-frame/register-handler
 :tasks-create-update
 (fn [db [_ field value]]
   (assoc-in db [:tasks :create field] value)))

(re-frame/register-handler
 :tasks-update
 (fn [db [_ task]]
   (let [tasks-url (get-in db [:tasks :url])
         auth-token (get-in db [:auth :token])]
     (PUT (str tasks-url "/" (:id task))
          {:format :json :keywords? true
           :params task
           :headers {:Authorization (str "Bearer " auth-token)}
           :handler #(re-frame/dispatch [:tasks-init])
           :error-handler #(println "error" %)})
     (update-in db [:tasks :data] #(mapv (fn [t] (if (= (:id t) (:id task)) task t)) %)))))

(re-frame/register-handler
 :tasks-delete
 (fn [db [_ task]]
   (let [tasks-url (get-in db [:tasks :url])
         auth-token (get-in db [:auth :token])]
     (DELETE (str tasks-url "/" (:id task))
             {:headers {:Authorization (str "Bearer " auth-token)}
              :handler #(re-frame/dispatch [:tasks-init])
              :error-handler #(println "error" %)})
     (update-in db [:tasks :data] #(filterv (fn [t] (not (= (:id t) (:id task)))) %)))))
