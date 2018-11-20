package com.ua.sutty.lab8;

import interfaces.task8.SerializableUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.*;

/**
 * @author yura
 */
public class SerializableUtilsTest implements Serializable {
    private static Class testingClass;

    private SerializableUtils utils;
    private ByteArrayOutputStream out = null;
    private ByteArrayInputStream in = null;

    @Before
    public void before() throws Exception {
        utils = new SerializableUtilsImpl();
        out = new ByteArrayOutputStream();
    }

    @After
    public void after() throws Exception {
        out.close();
        if (in != null)
            in.close();
    }

    @Test
    public void testSerializeNull() throws Exception {
        try {
            utils.serialize(null, "123");
            fail("out should be tested for null");
        } catch (NullPointerException ex) {
        } catch (Exception ex) {
            fail("out should be tested for null");
        }

        try {
            utils.serialize(new ByteArrayOutputStream(), null);
            fail("obj should be tested for null");
        } catch (NullPointerException ex) {
        } catch (Exception ex) {
            fail("obj should be tested for null");
        }
    }

    @Test
    public void testSerialize() throws Exception {
        ForSerialization objectForSerialization = new ForSerialization();
        objectForSerialization.setMustBeSaved("first Str");
        objectForSerialization.setMustNotBeSaved("second Str");

        ForSerialization desireolizedObject;
        try {
            utils.serialize(out, objectForSerialization);
            assertFalse("Size of serialazed object equal to 0", out
                .toByteArray().length == 0);

            in = new ByteArrayInputStream(out.toByteArray());
            desireolizedObject = (ForSerialization) utils.deserialize(in);

            assertEquals("Field not equals after deserialize",
                objectForSerialization.getMustBeSaved(), desireolizedObject
                    .getMustBeSaved());

            assertNull("Field must be null after deserialize",
                desireolizedObject.getMustNotBeSaved());

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Error while serialization/deserialization " + ex);
        }
    }

    @Test
    public void testSerializeWrong() throws Exception {
        NotSerializable notSerializable = new NotSerializable();
        notSerializable.setSomeField("Some value");

        try {
            utils.serialize(out, notSerializable);
            fail("Serialized object that not implement Serializable");
        } catch (Exception ex) {
            if (this.getCause(ex, NotSerializableException.class) != null) {
                return;
            }
            fail("NotSerializableException should be as cause of any "
                + "RuntimeException");
        }
    }

    @Test
    public void testDeserializeNull() throws Exception {
        try {
            utils.deserialize(null);
            fail("in should be tested for null");
        } catch (NullPointerException ex) {
        } catch (Exception ex) {
            fail("in should be tested for null");
        }
    }

    @Test
    public void testDeserializeWrong() throws Exception {
        in = new ByteArrayInputStream(new byte[0]);
        in.close();

        try {
            utils.deserialize(in);
        } catch (Exception ex) {
            if (this.getCause(ex, IOException.class) == null) {
                fail("Deserialization on empty Input Stream " + ex);
            }
        }
    }


    private Throwable getCause(Throwable th, Class clazz) {
        while (th != null) {
            if (clazz.isInstance(th)) {
                return th;
            }
            th = th.getCause();
        }
        return null;
    }

    public static class ForSerialization implements Serializable {
        private String mustBeSaved;
        private transient String mustNotBeSaved;

        public String getMustBeSaved() {
            return mustBeSaved;
        }

        public void setMustBeSaved(String mustBeSaved) {
            this.mustBeSaved = mustBeSaved;
        }

        public String getMustNotBeSaved() {
            return mustNotBeSaved;
        }

        public void setMustNotBeSaved(String mustNotBeSaved) {
            this.mustNotBeSaved = mustNotBeSaved;
        }
    }

    public static class NotSerializable {
        private String someField;

        public String getSomeField() {
            return someField;
        }

        public void setSomeField(String someField) {
            this.someField = someField;
        }
    }

}
