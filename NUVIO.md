# TurkSinema — Nuvio / CNCVerse Bridge

TurkSinema CloudStream eklentilerini **CNCVerse Bridge** üzerinden Nuvio'da kullanabilirsin.

## Kurulum

### 1. CNCVerse Bridge'i kur ve çalıştır

Bridge'i açıp sunucuyu başlat.

### 2. Bridge'e TurkSinema deposunu ekle

Bridge içindeki **Manage Repos / Depoları Yönet** bölümünden şu adresi ekle:

```text
https://raw.githubusercontent.com/PRoDi79/TurkSinema/main/repo.json
```

Bridge, CloudStream repository formatındaki `repo.json` dosyasını okuyarak `pluginLists` içindeki eklenti listesini yükler. Bridge kaynak kodunda repository manifesti doğrudan `name`, `iconUrl`, `description`, `manifestVersion` ve `pluginLists` alanlarıyla okunmaktadır.

### 3. Eklentileri Bridge üzerinden kur

TurkSinema deposu Bridge'in **Extensions / Eklentiler** bölümünde göründüğünde istediğin sağlayıcıları buradan kurabilirsin.

### 4. Nuvio

CNCVerse Bridge çalışırken Nuvio, Bridge'in yerel addon'unu otomatik olarak algılar. Nuvio'ya GitHub'daki `nuvio.json` dosyasını **Addon URL olarak ekleme**.

Bridge'in oluşturduğu yerel manifest adresi örneğin:

```text
http://127.0.0.1:8080/manifest.json
```

olabilir. Bridge farklı bir adres/port gösterirse onun verdiği adres kullanılır. Bridge'in resmi kullanım açıklamasına göre Nuvio tarafında manuel URL yapıştırmak gerekmemektedir.

## Önemli

`nuvio.json` dosyası bu repository'de bulunsa da **Nuvio'nun Addon URL alanına eklenecek Stremio manifesti değildir**. Nuvio, Stremio uyumlu bir `manifest.json` bekler; CNCVerse Bridge bu manifesti kendi yerel sunucusu üzerinden sağlar.

TurkSinema'nın CloudStream repository adresi:

```text
https://raw.githubusercontent.com/PRoDi79/TurkSinema/main/repo.json
```

Bridge bu repo üzerinden:

```text
PRoDi79/TurkSinema/repo.json
        ↓
PRoDi79/TurkSinema/builds/plugins.json
        ↓
PRoDi79/TurkSinema/builds/*.cs3
```

zincirini kullanır.

> Not: CNCVerse Bridge hâlen alpha aşamasındadır. Bazı CloudStream sağlayıcıları, özellikle WebView veya Cloudflare gerektirenler, Bridge ortamında çalışmayabilir. Android sürümünde WebView desteği masaüstü sürümüne göre daha kapsamlıdır.
