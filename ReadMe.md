# Todo App

#### Bu proje bir Yapılacaklar Listesini tutabileceğiniz backend ve frontend kısımlarıdan oluşan bir FullStack Projedir. Proje'nin amacı kişini günlük hayatında yapması gereken iş ve görevleri rahatça not edip, takip edebilmesini sağlamaktadır.

- Projede bizim girdiğimiz yapılacak maddeleri listeler halinde sıralar.Sıralama maddelerin kayıda girilme sırasına göredir.
- Listede bulunan her bir madde "Yapılacak" ve "Yapıldı" olarak iki farklı durum alır.
- "Yapıldı" durumunda olanların üstü kırmızı çizgi ile çizili durumda'dır.
- Liste'de bulunan maddelerin içerik ve durumlarını değiştirmek mümkün.

## Kullanım

- Proje ön yüzde bütün listeyi tutar. Listede yazan her bir görevin yanında bir checkbox, bir update imgesi ve bir de delete imgesi bulunur.

<img src="ReadmeImg\list.png" width="355px" >

- Liste'de bulunan madde'nin yanındaki checkbox'a tıklayarak maddeinin durumunu değiştirebilirsiniz.

- Liste'de bulunan madde'nin yanındaki kalem imgesi update'i simgeler. Buraya tıklarsanız açılan popup'taki inputtan maddenin içeriğini değiştirebilirsniz.

<img src="ReadmeImg\update.png" width="255px" >

- Liste'de bulunan madde'nin yanındaki çöp kutusu imgesine tıklarasnız maddeyi silersiniz.

- Listenin altında bulnan butonlar ise toplu silme butonlarıdır. "Delete All Tasks" ile tüm listeyi, "Delete Done Tasks" butonu ise "Yapıldı" statüsünde bulunan tüm maddleri siler.

- Listeini yukarısında bulunan "All","Todo","Done" butonları ise listelencek maddelere karar verir.

- Default olan liste "All" listesi'dir, Tüm maddeleri gösterir.

- "Todo" butonu "Yapılacak" durumunda olan maddeleri gösterir.

<img src="ReadmeImg\todo.png" width="285px" >

- "Done" butonu "Yapıldı" durumunda olan maddeleri gösterir.

<img src="ReadmeImg\todo.png" width="285px" >

- En yukarıda bulunan input ile yeni madde eklenir. İnputa yazılan yazı sonrası "Add New Task" butonuna tıklarsanız, yeni madde "Yapılacak" modunda eklenir.

## Kullanılan Teknolojiler ve Bağımlılıklar

#### Frontend kısmında:
- Proje React.js kullanılarak hazırlanmıştır.
- Rest Api ile bağlantı için axios kullanılmıştır.
- Styling için scss kullanılmıştır.
- Store yapısı için redux-toolkit tercih edilmiştir.

#### Bağımlılıklar

 - @reduxjs/toolkit : "^1.9.5"
 - axios: "^1.4.0"
 - react : "^18.2.0"
 - react-dom : "^18.2.0",
 - react-redux : "^8.1.1"
 - react-scripts : "5.0.1"
 - web-vitals: "^2.1.4"

#### Backend kısmında:
- Proje backend kısmında Spring boot ve türevleri ile hazırlanmıştır.
- Web kısmının entegrasyonu için Spring-Web'den yararlanılmıştır.
- Validation işlemleri için spring-boot-starter-validation kullanılmıştır.
- Mapper dönüşümleri için ModalMapper'dan yararlanılmıştır.
- Daha rahat kod yazımı için Lombok kütüphanesi aktif edilmiştir.
- Veritabanında product için PostgreSql'de karar kılınmıştır.
- Veritabanı işlemleri için Hibernate kütüphanesi ve Jpa kullanılmıştır.
- Dökümantasyon için Swagger ui eklenmiştir.
- Bağımlılık Yönetimi için ise Maven kullanılmıştır.

#### Bağımlılıklar

- Spring Boot Starter Data JPA
- Spring Boot Starter Validation:
- Spring Boot Starter Web:
- Spring Boot DevTools:
- PostgreSQL Driver:
- Lombok:
- Spring Boot Starter Test:
- ModelMapper:
- Spring WebMVC:

## Kurulum

### Ön Gereksinimler:
1. JDK: JDK yüklü olamalı, değil ise JDK'nın en son sürümünü [indirin](https://www.oracle.com/java/technologies/downloads/#java11) ve kurun.
2. Node.js : Node.js yüklü olmalı değil ise en son sürümünü [indirin](https://nodejs.org) ve bilgisayarınıza kurun.
3. PostgreSql  : PostgreSQL yüklü değilse, aşağıdaki adımları izleyerek PostgreSQL'in en son sürümünü [indirin](https://www.postgresql.org/download) ve kurun.
4. GitBash:  Projeyi clone'lama ve çalıştırma işlemleri için gerekli.

#### Ön gereksinimleri tamamladıktan sonra kurulum için projeyi github sayfasıdan clone'lamalıyız.
```
git clone https://github.com/kadirgurturk/TodoFullStack.git
```

#### Önce backend kurulur.
- Proje backend bölümüne gidilir
```
    cd TodoRestAPI/
```
- Gerekli kurulumlar yapılır:
```
    mvn clean install
```
- Uygulama run edilir ve service http://localhost:2222 ayağa kalkar.
```
    mvn spring-boot:run
```
#### Sonra Frontend.

- Proje frontend bölümüne gidilir
```
    cd todo-app/
```
- Gerekli kurulumlar yapılır:
```
   npm install
```
- Proje run edilir ve http://localhost:3000'de site ayağa kalkar.
```
    npm run start
```

## Proje Dizin Yapısı

```
    ReadmeImg/ -----> ReadMe dosyası içindeki görseller tutulur.
    todo-app/  -----> Frontend dosyaları burada bulunur.
         public/
            - index.Html -----> root html.
         src/
            assets/ ---------> Projede kullanılan svg ve image'lar bulunur.
            component/ ------> Projedeki component yapıları bulunur.
                    - TodoBtns.jsx  -------> Hangi Maddelerin listeleneceği seçilen butonlar bulunur
                    - TodoInput.jsx -------> Yeni madde ekleyen input burada bulunur.
                    - TodoList.jsx --------> Maddeler burada listelenir.
                    - UpdatePopup.jsx -----> Madde'nin içeriğini değiştiren input popup'ı burada bulunur. 
            css/ ------------> Scss konfigürasyonu sonunda oluşan css dosyası burda bulunur
            reducer/ -------> redux-createSlice yapıları bu dosyada bulunur.
                    - listReducer ---------> Hangi liste'nin yayınlanacağını store'da aktarır.
            scss/ ----------> scss dosyaları burada bulunur, herbir component için ayrı scss dosya bulunur.
            service/ -------> Api isteklerini kolaylaştırmak için service sınıfı bulunur.
            store/ ---------> Global store bulunur.  
            - App.js -------> Tüm componenetler burada toparlanır.
            - İndex.js -----> Kök html'e bağlantı buradan yapılır.       
         - .gitignore
         - package.json
         - package-lock.json   
    TodoRestAPI/ ---> Rest Service burada bulunur.
         - .idea -------> IDEA yapılandırma dosyaları bulunur.
         - .mvn --------> Maven yapılandırma dosyları.
         src/
            main/
                java/ ---------->
                    com/
                        kadirgurturk/
                            TodoRestAPI/
                                    bean/ ----> Proje çalıştığında lazım olan yapılar burada otomarik şekilde yazılır.
                                    buisness/
                                        dto/     -------> Dto yapılıarı bulunur.
                                        service/   -----> Service yapıları bulunur.
                                    configuration/ -----> Gerekli konfigürasyonlar burada yapılır.
                                    controller/
                                        api/ ----------> Web service kısmı burada bulnur.
                                    data/    ---------> Veritabanı işlemleri
                                        entity/ -----> Entity burada bulnur.
                                        enums/  -----> Enum yapısı
                                        repository/ -> Jpa Repo burada bulnur
                                    error/ -----------> Eror sınıfları bulnur.
                                    excepiton/ -------> Excepiton sınıfları burada bulnur.
                                    util/ ------------> Ek işlemler ve değişkenler burda tutulur.
                                    - TodoRestApiApplicaiton.java
                resources/ ----->
                    static
                    templates
                    application.properties -------> Proje içi ayarlamalr burda yapılır.
            test/ -----> Test İşlemleri bulunur.
         - .gitignore
         - DockerFile --> Docker işlemleri burada bulunur
         - mvnw --------> Maven Wrapper
         - pom.xml------> Pom yapılandırmaları bulunur 
    -ReadMe.md -----> ReadMe dosyası
```

