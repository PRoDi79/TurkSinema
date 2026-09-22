# TurkSinema Provider Standardi

Amaç: Eski Wiojelt/Kekik providerlarini gereksiz ortak katmanlardan arindirip sade, bakimi kolay CloudStream Kotlin providerlarina dönüştürmek.

## Standart

- Her provider kendi `MainAPI` sinifina sahip olur.
- Wiojelt/WioCore/WioPoll gibi repo-özel ortak UI veya servisler yeni providerlara alinmaz.
- `getMainPage`, `search`, `load` ve `loadLinks` yalnizca gereken providerlarda uygulanir.
- `quickSearch`, trailer ve subtitle sadece site gerçekten destekliyorsa eklenir.
- Domain tek bir kaynakta tutulur; domain degisikligi için provider kodunu gereksiz yere dagitmayiz.
- Gereksiz HTTP istekleri, tekrarli sayfa taramalari ve kullanilmayan parserlar temizlenir.
- TV için hizli acilis ve düşük bellek kullanimi önceliklidir.
- Playback davranisi gerçek istek zinciriyle dogrulanmadan `playbackVerified` gibi bir iddia yapilmaz.
- Her provider güncellendiginde sürüm bir üst sayiya çıkar ve metadata tarafinda gelistirici `mgg` olur.

## Kaynak önceligi

1. Güncel ve dogrulanabilir `.kt` kaynak.
2. Eski `.kt` kaynak + güncel site analizi.
3. Çalisan `.cs3` içinden kurtarilan davranis + yeniden yazilmis `.kt`.
4. Kaynak ve çalisan paket yoksa sifirdan provider.

## Build

Build sistemi CloudStream Gradle yapisini kullanacak. GitHub Actions yalnizca derleme ve paketleme degil, manifest sürümü ile `plugins.json` hash/size alanlarinin ayni paketi göstermesini de kontrol edecek.

## 666Film ilk referans

`AltiYuzAltmisAltiFilmIzle` ilk gerçek migrasyon hedefidir. Eski `.cs3` paketinden elde edilen davranislar kaynak olarak kullanilabilir; ancak Wiojelt ortak ayar/poll/domain tarama katmani yeniden kullanilmaz.

## Lisans

Eski provider kaynaklari alinmadan önce ilgili kaynak dosyasinin lisans ve atif kosullari kontrol edilir. Kaynak kod lisansi buna izin vermiyorsa kod birebir kopyalanmaz; davranis gözlemlenerek temiz bir yeniden uygulama yapilir.
