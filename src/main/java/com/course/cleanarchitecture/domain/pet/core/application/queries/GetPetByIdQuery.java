package com.course.cleanarchitecture.domain.pet.core.application.queries;

import lombok.Getter;

import java.util.UUID;

@Getter
public class GetPetByIdQuery {

    private UUID id;

    private GetPetByIdQuery() {
    }

    public GetPetByIdQuery(UUID id) {
        this.id = id;
    }
}


//1. Убрать jakarta.persistence из Domain (критично)
//        Удалить @Column из Address.java. Создать AddressJpa.java в адаптере. Исправить OwnerPetEntity чтобы он использовал AddressJpa, а не доменный Address.
//
//        2. Исправить DomainEvent (критично)
//        Заменить extends ApplicationEvent на обычный абстрактный класс или интерфейс. OutboxDomainEventPublisherImpl работает с JSON-сериализацией — ApplicationEvent там не нужен.
//
//        3. Исправить баг в MedicalCard (критично)
//        this.analyses = analyses; — добавить эту строку в конструктор. Также сделать receptionsId полем private.
//
//        4. Реализовать OwnerPetRepositoryImpl (критично)
//        Убрать return null, написать реальную реализацию аналогично PetRepositoryImpl.
//
//        5. Добавить бизнес-логику в агрегаты
//        Doctor.addReception() — проверить дубликаты. OwnerPet — добавить валидацию полей и метод addPet(UUID petId) с инвариантами.
//
//        6. Добавить ArchUnit тест
//        Автоматически поймает нарушения Dependency Rule. Тест на "..domain.." не должен зависеть от "jakarta.persistence.." или "org.springframework..".