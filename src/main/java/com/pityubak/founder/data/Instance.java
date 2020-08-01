package com.pityubak.founder.data;

/**
 *
 * @author Pityubak
 */
public class Instance {

    private final String name;
    private final Class<?> cls;

    public Instance(Builder builder) {
        this.name = builder.name;
        this.cls = builder.cls;
    }

    public String getName() {
        return name;
    }

    public Class<?> getCls() {
        return cls;
    }

    public static class Builder {

        private String name;

        private final Class<?> cls;

        public Builder(Class<?> cls) {
            this.cls = cls;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Instance build() {
            return new Instance(this);
        }
    }

    @Override
    public String toString() {
        return "Target{" + "name=" + name + ", cls=" + cls + '}';
    }

    
}
