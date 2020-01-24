package cw3

//Dla poniższych definicji list:
//def list1 = [ 'a', 'b', 'c']
//def list2 = [ 1, 8, 23 ]
//
//za pomocą metody each(Closure)
//a) wypisać wszystkie elementy (2 p.),
//b) stworzyć nowe listy list11 i list12 zawierające podwojone wartości list oryginalnych (3 p.).

def list1 = ['a', 'b', 'c']
def list2 = [1, 8, 23]

println "a) wypisać wszystkie elementy:"
printAll(list1)
printAll(list2)

println "b) stworzyć nowe listy list11 i list12 zawierające podwojone wartości list oryginalnych:"
def list11 = createListWithDoubleValues(list1)
def list12 = createListWithDoubleValues(list2)

printAll(list11)
printAll(list12)

def printAll(list) {
    list.each { println(it) }
}

def createListWithDoubleValues(list) {
    def newList = []
    list.each {
        newList.add(it * 2)
    }
    return newList
}
