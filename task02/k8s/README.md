# Развертывание приложения

## Обновляем списки пакетов в репозиториях, и устанавливаем архив сабчарта в каталог *charts/*

```
helm dependency update ./task02
```

## Устанавливаем чарт

```
helm install homework ./task02
```