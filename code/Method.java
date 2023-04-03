    package com.company;

    public class Method extends BaseModel{
        String name;
        String description;

        public Method(){
        }

        public Method(long id_method,String name,String description){
            super(id_method);
            this.name = name;
            this.description = description;
        }

        public String getName(String name){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public long getId() {
            return super.getId();
        }

        @Override
        public void setId(long id) {
            super.setId(id);
        }
    }

