## WBA2 SoSe13 Aufgaben Phase 1

**Aufgabe 1**  
Erklären Sie kurz die Begriffe Wohlgeformtheit, Validität und Namespaces im Bezug auf XML und XML-Schema.  
<br>

</br>
*Wohlgeformtheit*  
Unter Wohlgeformtheit bei XML versteht man die Übereinstimmung der Elementtypbezeichnung im Start- und Endtag.
`<wohlgeformt>Beispiel</wohlgeformt>`  

Stimmen die Bezeichnungen nicht überein (z.B. durch Schreibfehler) oder wurden die Tags vertauscht, so wird ein Fehler ausgegeben.  
`<nichtwohlgeformt>Tags stimmen nicht überein</wohlgeformt>` -> Fehler  

```
<wohlgeformt>  
     <nichtwohlgeformt>Tags wurden vertauscht</wohlgeformt> 
</nichtwohlgeformt>
```   
<br>

</br> 
*Validität*  
Ein XML-Dokument gilt als _valide_, ist also gültig, wenn es zum einen wohlgeformt ist und zum anderen auf Gültigkeit geprüft wurde.
Es wird darauf geachtet, dass alle geforderten Elemente eines bestimmten Typs enthalten sind bzw. enthalten sein können und in der richtigen Reihenfolge stehen.
Werden Regeln gesetzt, die zwischen gültig und ungültig unterscheinden, so besteht die Gültigkeit darin, dass diese Regeln erfüllt werden.


Zur Prüfung gibt es zwei Möglichkeiten:  

- Variante 1: Dokumenttyp-Definition DTD  
Die DTD steht zu Beginn des XML Dokuments und stellt eine Deklaration der Elementtypen dar, die in der XML Datei Verwendung finden.  
  
Beispiel  

```
<?xml version="1.0"?>

<!DOCTYPE wurzelName [
     <!Element wurzelName (subElement1, subElement2, subElement3)>  
     
     <!Element subElement1 (#PCDATA)>  
     <!Element subElement2 (#PCDATA)>  
     <!Element subElement3 (#PCDATA)>

]>

-- Beginn XML-Datei --

```

- Variante 2: XML Schema


<br>
</br>

*Namespaces*  
Durch die freie Wahl von Element- und Attributnamen, können identische Bezeichnungen bei unterschiedliche Anwendungsbereiche auftreten. 
Diese mehrdeutigen Namen, stehen jeweils in unterschiedlichem Kontext, müssen aber vom Programm auseinander gehalten werden.  
Um die Eindeutigkeit der Namen zu gewährleisten, wurden _Namensräume_ eingeführt, die in der Regel über eine URL referenziert werden.  

In der Anwendung kann das über eine Zuordnung eines Präfixes geschehen:  
```
'nr' wird als Kürzel für die Namensraum eingerichtet
<bspNamespace xmlns:nr="http://Namensraum.com/beispiel">
...
</bspNamespace>
```  
Wird beispielsweise die Bezeichnung "Vorname" in mehreren Fällen gebraucht, 
so kann über das zuvor deklarierte Präfix ein spezieller Kontext ausgewählt werden.
`<nr:Vorname>Dennis</nr:Vorname>`  

<br>
</br>

**Aufgabe 3**  
b) Betrachten Sie nun andere Rezepte auf der Webseite http://www.chefkoch.de.  
Beschreiben Sie welche Gemeinsamkeiten die Rezepte hinsichtlich ihrer Daten haben und worin Sie sich unterscheiden.


-Lösung Aufgabe 3b-





c) Arbeiten Sie die Kriterien heraus, die für die Entwicklung einer XML-Schema-Datei beachtet werden müssen.
Die Schema-Datei soll die Struktur für eine XML-Datei definieren, in der mehrere unterschiedliche Rezepte gespeichert werden können. 
Ziel ist es, dass das XML-Schema möglichst restriktiv ist,so dass in der XML-Datei möglichst semantisch sinnvolle Daten bezüglich der 
Rezepte gespeichert werden können. Ziehen Sie beim Aufstellen der Kriterien u.A. folgende Fragestellungen in Betracht:
  * Welche Daten müssen in simple und welche in complex-types abgebildet werden?  
  * Für welche Daten ist die Abbildung in Attributen sinnvoller?  
  * Welche Datentypen müssen für die Elemente definiert werden?  
  * Welche Restriktionen müssen definiert werden?


-Lösung Aufgabe 3c-


**Aufgabe 5**  
Diskutieren Sie, warum es sinnvoll ist Daten in Formaten wie XML oder JSON zu speichern.  
Stellen Sie außerdem die beiden Formate gegenüber und erläutern Sie kurz deren Vor- und Nachteile.

XML:
**Speichert** die reinen **Daten** ohne irgendwelche formalen Vorschriften zu geben und ermöglicht einen einfachen **Transport**. 
XML Dateien sind **Software- und Hardwareunabhängig**, wodurch eine große **Interoperabilität** geschaffen ist, die **Komplexität verringert wird** und ein Datensatz 
in vielen unterschiedlichen Anwendungen zum Einsatz kommen kann.
