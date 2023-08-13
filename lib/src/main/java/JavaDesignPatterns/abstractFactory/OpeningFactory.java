package JavaDesignPatterns.abstractFactory;

import JavaDesignPatterns.abstractFactory.models.enums.Type;

public interface OpeningFactory<T> {
    T create(Type type) throws Exception;
}
