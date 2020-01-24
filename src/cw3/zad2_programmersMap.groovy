package cw3

//Firma software'owa prowadzi projekty w:
//Groovy, Grails, Java, JEE
//Do każdego projektu przypisani są programiści, co pokazuje poniższa mapa:
//
//def pmap = [ Groovy: [ 'Asia', 'Jan' ],
//                     Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
//                     Java: [ 'Asia', 'Stefan', 'Mirek' ],
//                     JEE: [ 'Slawek', 'Stefan', 'Janusz' ]
//                   ]
//Wypisać:
//a) ile osób pracuje w każdym z projektów  (3 p)
//b) projekty, które mają więcej niż dwóch programistów (3p )
//c)  w jakich projektach biorą udzial poszczególni programisci (6 p.)

def pmap = [Groovy: ['Asia', 'Jan'],
            Grails: ['Asia', 'Jan', 'Stefan', 'Mirek'],
            Java  : ['Asia', 'Stefan', 'Mirek'],
            JEE   : ['Slawek', 'Stefan', 'Janusz']
]

println "a) ile osób pracuje w każdym z projektów:"
pmap.each { k, v -> println(k + ': ' + v.size() + ' osoby') }

println "b) projekty, które mają więcej niż dwóch programistów:"
pmap.each { k, v ->
    if (v.size() > 2)
        println(k)
}

println "c) w jakich projektach biorą udzial poszczególni programisci:"
def programmersToProjectsMap = [:]

pmap.each {k, v ->
    v.each {p ->
        def projects = programmersToProjectsMap[p]
        if (projects == null) {
            programmersToProjectsMap.put(p, [k])
        } else {
            projects.add(k)
        }
    }
}

println(programmersToProjectsMap)
