## WBA2 SoSe13 Aufgaben Phase 1

**Aufgabe 1**  
Erklären Sie kurz die Begriffe Wohlgeformtheit, Validität und Namespaces im Bezug auf XML und XML-Schema.  

<br>
*Wohlgeformtheit*  
Unter Wohlgeformtheit bei XML versteht man die Einhaltung definierter Syntaxregeln wie die Übereinstimmung der Elementtypbezeichnung im Start- und Endtag.
`<wohlgeformt>Beispiel</wohlgeformt>`  

Stimmen die Bezeichnungen nicht überein (z.B. durch Schreibfehler) oder wurden die Tags vertauscht, so wird ein Fehler ausgegeben.  
`<nichtwohlgeformt>Tags stimmen nicht überein</wohlgeformt>` -> Fehler  

```
<wohlgeformt>  
     <nichtwohlgeformt>Tags wurden vertauscht</wohlgeformt> 
</nichtwohlgeformt>
```   

Weiterhin wird vorausgesetzt, dass die einzelnen Elemente Bestandteil eines Wurzelelementes sind und Attribute im Anfangstag mit Anführungszeichen versehen werden.  

```
<wurzelelement attname="attbeschreibung">
     	<subelement attname2="attbeschreibung2"></subelement>
</wurzelelement>
```


<br>
 
*Validität*  
Ein XML-Dokument gilt als _valide_, ist also gültig, wenn es zum einen wohlgeformt ist und zum anderen auf Gültigkeit geprüft wurde.
Es wird darauf geachtet, dass alle geforderten Elemente eines bestimmten Typs enthalten sind bzw. enthalten sein können und in der richtigen Reihenfolge stehen.
Werden Regeln gesetzt, die zwischen gültig und ungültig unterscheinden, so besteht die Gültigkeit darin, dass diese Regeln erfüllt werden.


Zur Prüfung gibt es zwei Möglichkeiten:  

- Variante 1: Dokumenttyp-Definition DTD  
Die DTD steht zu Beginn des XML Dokuments als interne/externe DTD und stellt eine Deklaration der Elementtypen dar, die in der XML Datei Verwendung finden.  
  
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

- Variante 2: XML Schema (Regeln dazu folgen in Aufgabe 3c)

<br>

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

<br>
_Gemeinsamkeiten_  
Rezepte auf der Seite haben immer einen **Rezeptname** mit eigener **Rezeptid** (URL Referenz).  
Die ID ist notwendig und lässt sich daraus entnehmen, dass man über unterschiedliche Kategorien auf das gleiche Rezept kommen kann.

Jedes Rezept setzt eine **Zutatenliste** vorraus und jede einzelne Zutat wird mit  **Menge und Einheit** sowie zugehörigem **Zutatenname** beschrieben.
Die Werte beziehen sich auf eine bestimmte **Anzahl Portionen**. Diese Angabe ist von Bedeutung um eine Umrechnung zu ermöglichen.

Dazu kommt eine Erklärung der **Zubereitung** in der die **unterschiedliche Merkmale** wie **Arbeitszeit**, **Schwierigkeitsgrad in festgelegten Domänen (simpel,normal)** und **Brennwert p.P** angegeben sind und eine **Beschreibung der Zubereitun** verfasst wird. 

<br>
_Unterschiede_  
Grundsätzlich setzt jedes Rezept die **Angaben der Gemeinsamkeiten** voraus.  
Als zusätzliche Daten können jedem Rezept, neben dem Rezeptnamen. noch eine **optionale Kurzbeschreibung** hinzugefügt werden.  
Es ist möglich ein oder mehrere **Bild(er)** hochzuladen, welches mit entspechendem Titel versehen werden.
Die Zutatenliste, die grundsätzlich Angaben enthalten muss, kann in **variable Unterkategorien** eingeteilt werden. 
Ebenso können für die **Zubereitung weitere Merkmale** zur Ruhezeit oder   
Koch-/Backzeit angegeben werden.

<br>
_Datentypen_  
Die einzelnen Informationen werden mit **Zahlenwerte** (u.a. bei Zutatenmenge,
Arbeitszeit und Brennwert) oder **Textwerten** beschrieben, gegebenfalls werden diese zusätzlich verlinkt.


<br>
</br>
c) Arbeiten Sie die Kriterien heraus, die für die Entwicklung einer XML-Schema-Datei beachtet werden müssen.
Die Schema-Datei soll die Struktur für eine XML-Datei definieren, in der mehrere unterschiedliche Rezepte gespeichert werden können. 
Ziel ist es, dass das XML-Schema möglichst restriktiv ist,so dass in der XML-Datei möglichst semantisch sinnvolle Daten bezüglich der 
Rezepte gespeichert werden können. Ziehen Sie beim Aufstellen der Kriterien u.A. folgende Fragestellungen in Betracht:
  * Welche Daten müssen in simple und welche in complex-types abgebildet werden?  
  * Für welche Daten ist die Abbildung in Attributen sinnvoller?  
  * Welche Datentypen müssen für die Elemente definiert werden?  
  * Welche Restriktionen müssen definiert werden?
  
 * _Namensraum definieren_  
 benutze Elemente in den XML Dokumenten entstammen den Bezeichnungen von "http:// www.chefkoch.de "
  
  * _Elementtypen identifizieren_  
  Elementtypen lassen sich generell in 2 Arten einstufen:
  <br>
  **Simple type**: einfache Elemente, die keine weiteren Elemente oder Attribute enthalten   
  **Complex type**: komplexe Typen, bei denen Elemente weitere Elemente oder Attribute enthalten können
  default Werte: automatisch Zugeordnet, wenn nicht anders definiert
  
  Attribute: optional oder required
Gruppen
   

* _Datentypen zuordnen_  
Basisdaten für Elemente und Attribute definiert durch "http://www.w3.org/2001/XMLSchema"  
string, integer, boolean, decimal, date, type  



* _Restriktionen festlegen_  
Werte an sich  
Menge von möglichen Werten  
Anzahl an Zeichen
Zutaten nur einmal



**Aufgabe 5**  
Diskutieren Sie, warum es sinnvoll ist Daten in Formaten wie XML oder JSON zu speichern.  
Stellen Sie außerdem die beiden Formate gegenüber und erläutern Sie kurz deren Vor- und Nachteile.

XML:
**Speichert** die reinen **Daten** ohne irgendwelche formalen Vorschriften zu geben und ermöglicht einen einfachen **Transport**. 
XML Dateien sind **Software- und Hardwareunabhängig**, wodurch eine große **Interoperabilität** geschaffen ist und ein Datensatz 
in vielen unterschiedlichen Anwendungen zum Einsatz kommen kann.

JSON:
Format zum Speichern und Austausch von Daten, ähnlich XML.JSON Dateien sind **Plattform** und **Sprachen unabhängig** und .von der Größe kleiner als XML Dateien 

Much Like XML
JSON is plain text
JSON is "self-describing" (human readable)
JSON is hierarchical (values within values)
JSON can be parsed by JavaScript
JSON data can be transported using AJAX

Much Unlike XML
No end tag
Shorter
Quicker to read and write
Can be parsed using built-in JavaScript eval()
Uses arrays
No reserved words
