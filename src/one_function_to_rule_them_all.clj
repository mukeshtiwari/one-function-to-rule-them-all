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
  (if (empty? a-seq) '()
      (reduce (fn [acc y] (concat acc (list x) (list y))) (list (first a-seq)) (rest a-seq))))

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



(defn split-into-two [sorted-seq n]
  (map reverse
    (reduce (fn [[accf accs] x]
              (cond
                (< x n) [(conj accf x) accs]
                :else [accf (conj accs x)])) ['() '()] sorted-seq)))

(split-into-two (list 1 2 4 5) 3)

(defn insert [sorted-seq n]
  (let [[fval sval] (split-into-two sorted-seq n)]
    (concat fval (list n) sval)))

(insert [] 2)      ;=> (2)
(insert [1 3 4] 2) ;=> (1 2 3 4)
(insert [1] 2)     ;=> (1 2)

(defn insertion-sort [a-seq]
  [:-])

(defn parity [a-seq]
  [:-])

(defn minus
  ([x] (- 0 x))
  ([x y] (- x y)))

(minus 2)   ;=> -2
(minus 4 3) ;=> 1

(defn count-params
  ([] 0)
  ([x] 1)
  ([x & more] (reduce (fn [acc y] (+ acc 1)) 1 more)))

(count-params)            ;=> 0
(count-params :a)         ;=> 1
(count-params :a 1 :b :c) ;=> 4

(defn my-*
  ([] 1)
  ([x] x)
  ([x y] (* x y))
  ([x y & more] (reduce * (* x y) more)))

(my-*)           ;=> 1
(my-* 4 3)       ;=> 12
(my-* 1 2 3 4 5) ;=> 120

(defn pred-and
  ([] (fn [y] true))
  ([p] (fn [y] (p y)))
  ([p q] (fn [y] (and (p y) (q y))))
  ([p q & more] (fn [y]  (reduce (fn [acc pred] (and acc (pred y))) (and (p y) (q y))  more))))

(filter (pred-and) [1 0 -2])                    ;=> (1 0 -2)
(filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) ;=> (1 7)
(filter (pred-and number? integer? pos? even?)
        [1 0 -2 :a 7 "a" 2])                    ;=> (0 2)

(defn partition-list [& more]
  (partition (count more) (apply interleave more)))

(apply interleave [[1 2 3] [1 2 3] [1 2 3]])
(partition-list [1 2 3] [ 1 2 3] [1 2 3])
(apply partition-list [[1 2 3] [1 2 3] [1 2 3]])

(defn my-map [f & more]
  (cond
    (= 1 (count more)) (reduce (fn [acc x] (conj acc (f x))) [] (first more))
    :else (reduce (fn [acc x] (conj acc (apply f x))) [] (apply partition-list more))))



(my-map inc [1 2 3 4])                  ;=> (2 3 4 5)
(my-map + [1 1 1] [1 1 1] [1 1 1])      ;=> (3 3 3)
(my-map vector [1 2 3] [1 2 3] [1 2 3]) ;=> ((1 1 1) (2 2 2) (3 3 3))
