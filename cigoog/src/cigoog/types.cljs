(ns cigoog.types
  (:require
    [cljs.pprint :as pp]
    [tiltontec.util.core :refer [ensure-vec]]
    [tiltontec.cell.base :refer [ia-type]]))

(def h5-type-tree
  [::h5.object
   ::h5.div
   ::h5.title ::h5.h2 ::h5.h3 ::h5.h4 ::h5.h5
   ::h5.p ::h5.label ::h5.image
   ::h5.button ::h5.input
   ::h5.ul ::h5.li
   ])


(defn derive-tree [super tree]
  (let [[class & subs] (ensure-vec tree)]
    (when super
      (derive class super))
    (doseq [sub subs]
      (derive-tree class sub))))

(derive-tree nil h5-type-tree)

(defmulti to-html ia-type)

(defmethod to-html :default [me]
  (pp/cl-format nil "<h4>No to-html for ~s</>" (ia-type me)))

(defmethod to-html ::h5.label [me]
  ;;(pln :labelling @me)
  "<i>almost</i>"
  #_
  (pp/cl-format nil "<label>Label ~a</>" 42 #_ (:value @me)))

