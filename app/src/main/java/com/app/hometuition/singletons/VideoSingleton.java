package com.app.hometuition.singletons;

public class VideoSingleton {
    public static Instance instance;

    private VideoSingleton() {
    }

    public static Instance getInstance() {
        if (instance == null)
            instance = new Instance(-1, "");
        return instance;
    }

    public static void setInstance(int res, String title) {
        VideoSingleton.instance = new Instance(res, title);
    }

    public static class Instance {
        int resource;
        String title;

        public Instance(int resource, String title) {
            this.resource = resource;
            this.title = title;
        }

        public int getResource() {
            return resource;
        }

        public String getTitle() {
            return title;
        }
    }
}
