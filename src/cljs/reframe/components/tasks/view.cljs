(ns reframe.components.tasks.view
  (:require [re-frame.core :as re-frame]
            [reframe.components.tasks.handler]
            [reframe.components.tasks.sub]
            ))

(defn task-item [task]
  [:div.reframe-tasks-task {:key (:id task)}
   [:button.reframe-tasks-delete
    {:on-click #(re-frame/dispatch [:tasks-delete task])}
    [:span.fa.fa-trash]]
   [:h3.reframe-tasks-title (:title task)]
   [:div.reframe-tasks-body
    [:label.reframe-form-checkbox "Done"
     [:input {:type "checkbox"
              :checked (:done task)
              :on-change #(re-frame/dispatch [:tasks-update (update-in task [:done] not)])}]]]
   [:p.reframe-tasks-updated (:updated_at task)]])

(defn title-input []
  (let [title (re-frame/subscribe [:tasks-create :title])]
    (fn []
      [:input {:key "title"
               :type "text"
               :placeholder "Enter task title"
               :value @title
               :on-change #(re-frame/dispatch [:tasks-create-update :title (-> % .-target .-value)])}])))

(defn ^:export tasks-create-on-submit []
  (re-frame/dispatch [:tasks-create]))

(defn tasks-create []
  [:div
   [:form {:id "new_task"
           :onSubmit tasks-create-on-submit}
    [:fieldset
     [:legend "Add new task"]
     [:label {:for "title"} "Title"]
     [title-input]
     [:button {:type "submit"
               :form "new_task"
               :value "submit"} "Create"]]]])

(defn view []
  (re-frame/dispatch [:tasks-init])
  (let [tasks (re-frame/subscribe [:tasks])]
    (fn []
      [:div.reframe-tasks
       (if (empty? @tasks)
         [:p "No Tasks"]
         (for [task @tasks] (task-item task)))
       [tasks-create]])))
