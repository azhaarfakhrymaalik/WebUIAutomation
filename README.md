Web UI Automation Testing Framework

Repositori ini berisi framework otomatisasi pengujian UI Web menggunakan: 
Java, Gradle, Selenium WebDriver, dan Cucumber (BDD) 
dengan menerapkan design pattern Page Object Model (POM).

Fitur Framework
- BDD Style: Menulis skenario uji menggunakan Gherkin (.feature).
- Page Object Model: Kode UI dan elemen *locator* terpisah dari logika tes, sehingga mudah dirawat (*maintainable*).
- Automated Reporting: Menghasilkan laporan bawaan berbasis HTML setelah pengujian selesai.
- Scenarios: Mencakup kasus uji Positif, Negatif, dan Batas (*Boundary/Empty Data*).

Prasyarat (Prerequisites)
Sebelum menjalankan project, perangkat sudah terinstal:
- Java JDK 17 atau versi terbaru.
- Google Chrome Browser terbaru.

Struktur Folder Utama
- `src/test/java/pageobjects` : Menyimpan elemen web dan fungsinya (POM).
- `src/test/java/stepdefinitions` : Logika pengendali instruksi Gherkin.
- `src/test/java/runners` : Pengaturan konfigurasi eksekusi tes JUnit & Cucumber.
- `src/test/resources/features` : Skenario uji berbasis file `.feature`.
