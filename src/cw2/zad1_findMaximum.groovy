package cw2

// Napisać funkcję odnajdującą maksimum z przekazanej listy obiektów (liczb, napisów) i zwracającą wartość maksymalną
// oraz pozycje (indeksy) listy na których ta wartość się znajduje. Użyć konstrukcji  eachWithIndex.

(maxVal, indList) = maximum( [5, 3, 5, 5, 1, 5] )
println "Maximum: $maxVal"
println "Indexes: $indList"

(maxVal, indList) = maximum(['a', 'c', 'c', 'c', 'b'])
println "Maximum: $maxVal"
println "Indexes: $indList"

static def maximum(def values) {
    def maxVal = values.max()
    def indList = []
    values.eachWithIndex { def entry, int i ->
        if (entry == maxVal) {
            indList.add(i)
        }
    }
    return [maxVal, indList]
}
