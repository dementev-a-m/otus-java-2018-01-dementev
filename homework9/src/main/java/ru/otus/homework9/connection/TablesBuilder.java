package ru.otus.homework9.connection;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import ru.otus.homework9.annotation.Column;
import ru.otus.homework9.annotation.Entity;
import ru.otus.homework9.annotation.Id;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Антон Дементьев on 02.05.2018.
 */
class TablesBuilder {
    private String packageName;

    TablesBuilder(String packageName) {
        this.packageName = packageName;
    }

    List<String> createEntities() {
        List<String> list = new ArrayList<>();
        Set<Class<?>> classes = this.getClassesForPackage();
        if (classes != null) {
            for (Class aClass : classes) {
                if (aClass.getAnnotation(Entity.class) != null) {
                    list.add(createEntity(aClass));
                }
            }
        }
        return list;
    }

    List<String> removeEntities() {
        List<String> list = new ArrayList<>();
        Set<Class<?>> classes = this.getClassesForPackage();
        if (classes != null) {
            for (Class aClass : classes) {
                if (aClass.getAnnotation(Entity.class) != null) {
                    list.add("drop table " + aClass.getSimpleName());
                }
            }
        }
        return list;
    }


    private String createEntity(Class entity) {
        String tableName = entity.getSimpleName();
        String idFieldName = null;
        String createTable = "create table if not exists " + tableName + " ( ";
        List<String> columns = new ArrayList<>();
        Field[] fields = entity.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Id.class) == null) {

                columns.add(createColumn(field));
            } else {
                idFieldName = field.getName();
                columns.add(createColumn(field) + " auto_increment");
            }
        }
        for (String column : columns) {
            createTable += column + ", ";
        }
        return createTable + " primary key (" + idFieldName + "))";

    }

    private String createColumn(Field field) {
        Column annotation = field.getAnnotation(Column.class);
        String nameTypeColumn = field.getType().getName();
        if (nameTypeColumn.equals("java.lang.String")) {
            nameTypeColumn = "VARCHAR";
        } else if (nameTypeColumn.equals("short") || nameTypeColumn.equals("int") || nameTypeColumn.equals("java.lang.Integer")) {
            nameTypeColumn = "INT";
        }
        if (nameTypeColumn.equals("long") || nameTypeColumn.equals("java.lang.Long")) {
            nameTypeColumn = "BIGINT";
        }
        return getColumnName(field, annotation) + " " + nameTypeColumn + getSizeColumn(annotation, nameTypeColumn);
    }

    private String getColumnName(Field field, Column annotation) {

        if (annotation.name().equals("")) {
            return field.getName();
        } else return annotation.name();

    }

    private String getSizeColumn(Column annotation, String nameTypeColumn) {
        int size = annotation.size();
        if (size == -1) {
            switch (nameTypeColumn) {
                case "VARCHAR":
                    size = 256;
                    break;
                case "INT":
                    return "";
                case "BIGINT":
                    return "";
                default:
                    return "";
            }

        }
        return "(" + size + ")";
    }

    private Set<Class<?>> getClassesForPackage() {
        List<ClassLoader> classLoadersList = new LinkedList<>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(packageName))));
        return reflections.getSubTypesOf(Object.class);
    }

}
