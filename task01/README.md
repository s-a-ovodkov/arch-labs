Задание #1
----------
##### Основы работы с Kubernetes
###### Цель:
> Создать минимальный сервис
###### Требования:
* Создать минимальный сервис, отвечающий на порту 8000, имеет http-метод GET /health/ RESPONSE: *{"status": "OK"}*
* Собрать локально образ приложения в докер и запушить его в dockerhub
* Написать манифесты Deployment, Service, Ingress для деплоя этого сервиса в k8s.
* Количество реплик должно быть не меньше 2
* Хост в ингрессе должен быть arch.homework, а так же должно быть правило, которое форвардит все запросы с /otusapp/{student name}/... на сервис с rewrite-ом пути В итоге после применения манифестов GET запрос на http://arch.homework/health должен отдавать *{“status”: “OK”}*.