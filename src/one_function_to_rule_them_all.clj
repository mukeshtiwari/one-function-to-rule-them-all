(ns one-function-to-rule-them-all)

(defn concat-elements [a-seq]
  (reduce concat '() a-seq))

(concat-elements [])            ;=> ()
(concat-elements [[1 2]])       ;=> (1 2)
(concat-elements [[1 2] [3 4]]) ;=> (1 2 3 4)

(defn str-cat [a-seq]
  (if (empty? a-seq) ""
      (reduce (fn [acc x] (str acc " " x))  a-seq)))


(str-cat ["I" "am" "Legend"])  ;=> "I am Legend"
(str-cat ["I" "am" "back"])    ;=> "I am back"
(str-cat ["more" " " "space" ]) ;=> "more   space"
(str-cat [])

(defn my-interpose [x a-seq]
  (reduce (fn [acc y] (concat acc (list x) (list y))) (list (first a-seq)) (rest a-seq)))

(my-interpose 0 [1 2 3])               ;=> (1 0 2 0 3)
(my-interpose "," ["I" "me" "myself"]) ;=> ("I" "," "me" "," "myself")
(my-interpose :a [1])                  ;=> (1)
(my-interpose :a [])                   ;=> ()

(defn my-count [a-seq]
  (reduce (fn [acc x] (+ acc 1)) 0 a-seq))

(my-count [])      ;=> 0
(my-count [1 2 3]) ;=> 3
(my-count [1])     ;=> 1

(defn my-reverse [a-seq]
  (reduce (fn [acc x] (cons x acc)) '() a-seq))

(my-reverse [1 2 3]) ;=> (3 2 1)
(my-reverse [1 2])   ;=> (2 1)
(my-reverse [])      ;=> ()

(defn min-max-element [a-seq]
  (reduce (fn [[accf accs] x]
            (cond
              (< x accf) [x accs]
              (> x accs) [accf x]
              :else [accf accs])) [(first a-seq) (first a-seq)] a-seq))

(min-max-element [2 7 3 15 4]) ;=> [2 15]
(min-max-element [1 2 3 4])    ;=> [1 4]
(min-max-element [1])          ;=> [1 1]

(defn insert [sorted-seq n]
  [:-])

(defn insertion-sort [a-seq]
  [:-])

(defn parity [a-seq]
  [:-])

(defn minus [x]
  :-)

(defn count-params [x]
  :-)

(defn my-* [x]
  :-)

(defn pred-and [x]
  (fn [x] :-))

(defn my-map [f a-seq]
  [:-])
