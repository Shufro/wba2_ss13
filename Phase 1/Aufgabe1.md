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

Weiterhin wird vorausgesetzt, dass die einzelnen Elemente Bestandteil eines Wurzelelementes sind und Attribute im Anfangstag mit Anführungszeichen (oder ' ') versehen werden.  

```
<wurzelelement attname="attbeschreibung">
  	<subelement attname2="attbeschreibung2"></subelement>
</wurzelelement>
```

Bezieht das ELement Inhalt, so muss dieser innerhalb eines Start- und Endtags stehen. Hat das Element keinen Inhalt ist auch die Form
`<Elementname />` möglich.


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

- Variante 2: XML Schema

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
