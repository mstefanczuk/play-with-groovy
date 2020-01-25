package cw4

//Firma software'owa prowadzi projekty w:
//Groovy, Grails, Java, JEE
//Plik Projekty.txt zawiera informacje o składzie osobowym każdego z projektów w postaci:
//nazwaprojektu<TAB>Nazwisko imie(1)<TAB>Nazwiskoimie(2)<TAB> itd
//Utworzyc pliki:
//ProjektyDuze.txt - zawierający spis projektów w którym pracuje > niż 3 osoby
//Programisci.txt - zawierajacy spis programistow w postaci:
//nazwisko imie<tab>proj1<tab>proj2<tab> itd.

def projectsInputFile = new File("Projekty.txt")
def projectsOutputFile = new File("ProjektyDuze.txt")
projectsOutputFile.text = ""
def programmersToProjectsFile = new File("Programisci.txt")
programmersToProjectsFile.text = ""
def programmersToProjectsMap = [:]

projectsInputFile.each {
    def splittedRow = it.split("\t")
    def project = splittedRow[0]
    def programmers = splittedRow.drop(1)

    if (programmers.size() > 3) {
        projectsOutputFile.text += project + "\n"
    }

    programmers.each {
        def projects = programmersToProjectsMap[it]
        if (projects == null) {
            programmersToProjectsMap.put(it, [project])
        } else {
            projects.add(project)
        }
    }
}

programmersToProjectsMap.each {
    def concatenatedProjects = ""
    it.value.each { concatenatedProjects += "\t" + it }
    programmersToProjectsFile.text += it.key + concatenatedProjects + "\n"
}
