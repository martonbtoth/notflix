Notflix
=======

Bevezetés
---------

A Notflix egy online video streamelő szolgáltatás, aminek célja, hogy a felhasználói kényelmesen elérhessék és megtekinthessék a platformban elérhető videó tartalmakat. Az alkalmazás több kisebb szolgáltatásra (microservice) épül, ezek között a kommunikációt és a koordinációt a [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/) könyvtár segíti. Az alkalmazás gerincét három fő microservice adja: a felhasználó-menedzsment modul, a streaming modul és a tartalom menedzsment modul.

### A fehasználó menedzsment modul

A felhasználó menedzsment modul feladata menedzselni a felhasználók regisztrációit, bejelentkeztetését, engedélyezni a tartalmak kiszolgálását. A szolgáltatásban két fő felhasználói csoport különíthető el: az előfizetők és az adminisztrátorok. Az előfizetők bejelentkezhetnek, böngészhetik és megtekinthetik az alkalmazásban elérhető tartalmakat. Az adminisztrátorok rendelkeznek a felhasználók összes jogkörével, ezen felül karbantarthatják az alkalmazás előfizetőit és videó tartalmait.

### A streaming modul

A streaming komponens feladata kiszolgálni a videolejátszást. A kényelmes lejátszás érdekében, még rossz hálózati viszonyok között is, a streaming modul (megfelelő böngésző esetén) képes [adaptív videostreamelésre](https://en.wikipedia.org/wiki/Dynamic_Adaptive_Streaming_over_HTTP). A stream indítása előtt a modul ellenőrzi, hogy a felhasználó jogosult-e az adott tartalom lejátszására.

### Tartalom menedzsment modul

A tartalom menedzsment modul feladata karbantartani és kereshetővé tenni az alkalmazásban elérhető videótartalmak metaadatait.

A modul a streaming modul segítségével naplózza, hogy a felhasználók milyen videókat tekintenek meg és ez alapján ajánl további videókat. A videók továbbá a modulban szereplő metaadatok alapján szabadszavasan kereshetők.

A modul képes továbbá külső adatforrásokból további metaadatokat letölteni és feldolgozni a platformban tárolt videókhoz.
