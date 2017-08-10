package com.example.yangyu.rxandroiddemo1;

import java.util.List;

/**
 * Created by yangyu on 17/8/9.
 */

public class Result {

    /**
     * error : false
     * results : [{"_id":"597af9c1421aa90ca3bb6b91","createdAt":"2017-07-28T16:45:53.174Z","desc":"Android开发中人脸识别(静态)","publishedAt":"2017-08-09T13:49:27.260Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/d054760c2477","used":true,"who":"drawthink"},{"_id":"597dce34421aa90ca209c51b","createdAt":"2017-07-30T20:16:52.80Z","desc":"一个极简但是强大的VR本地播放器，基于IJKPlayer、MD360Player4Android，并使用DataBinding","images":["http://img.gank.io/ea71986c-4e0f-4b21-97a5-06dc311fff0b"],"publishedAt":"2017-08-09T13:49:27.260Z","source":"web","type":"Android","url":"https://github.com/wheat7/VRPlayer","used":true,"who":"麦田哥"},{"_id":"59898c0f421aa90c9203d483","createdAt":"2017-08-08T18:01:51.839Z","desc":"Android 高级混淆和代码保护技术","images":["http://img.gank.io/edbfd9aa-493e-4be9-8fb9-b148025ae658"],"publishedAt":"2017-08-09T13:49:27.260Z","source":"web","type":"Android","url":"http://drakeet.me/android-advanced-proguard-and-security/","used":true,"who":"drakeet"},{"_id":"5985bdb6421aa97de5c7ca30","createdAt":"2017-08-05T20:44:38.849Z","desc":"由于RxJava发布了一个订阅后，由于没有及时取消，会导致内存泄露，本文介绍Rxlifecycle机制","publishedAt":"2017-08-08T11:34:20.37Z","source":"web","type":"Android","url":"http://url.cn/4Es2B0l","used":true,"who":"Tamic (码小白)"},{"_id":"5988179b421aa90c9203d47b","createdAt":"2017-08-07T15:32:43.864Z","desc":"Android8.0运行时权限策略变化和适配方案","publishedAt":"2017-08-08T11:34:20.37Z","source":"web","type":"Android","url":"http://blog.csdn.net/yanzhenjie1003/article/details/76719487","used":true,"who":"严振杰"},{"_id":"598876f5421aa90c9203d47d","createdAt":"2017-08-07T22:19:33.146Z","desc":"Maven 项目构建基础","publishedAt":"2017-08-08T11:34:20.37Z","source":"chrome","type":"Android","url":"https://zhuanlan.zhihu.com/p/28371336","used":true,"who":"王下邀月熊"},{"_id":"59892f06421aa90ca209c572","createdAt":"2017-08-08T11:24:54.865Z","desc":"气泡风格的 SeekBar，做的很漂亮。","publishedAt":"2017-08-08T11:34:20.37Z","source":"chrome","type":"Android","url":"https://github.com/sathishmscict/BubbleSeekBar","used":true,"who":"代码家"},{"_id":"598029be421aa90c9203d448","createdAt":"2017-08-01T15:11:58.619Z","desc":"Storybook 3.2 引入 Vue.js 支持","publishedAt":"2017-08-03T12:08:07.258Z","source":"chrome","type":"Android","url":"https://zhuanlan.zhihu.com/p/28239408","used":true,"who":"王下邀月熊"},{"_id":"59815d0b421aa90c9203d45c","createdAt":"2017-08-02T13:03:07.497Z","desc":"从零开始打造一个VR视频播放器","images":["http://img.gank.io/5feda1ac-7412-4d8c-bc33-dd8102d24c6a"],"publishedAt":"2017-08-03T12:08:07.258Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/c7a3b1acb8b1","used":true,"who":"麦田哥"},{"_id":"598176ac421aa90ca3bb6bd7","createdAt":"2017-08-02T14:52:28.638Z","desc":"Android 插件：统计资源文件中每个标签被引用的次数","publishedAt":"2017-08-03T12:08:07.258Z","source":"web","type":"Android","url":"https://github.com/niorgai/Android-Resource-Usage-Count","used":true,"who":"drakeet"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 597af9c1421aa90ca3bb6b91
         * createdAt : 2017-07-28T16:45:53.174Z
         * desc : Android开发中人脸识别(静态)
         * publishedAt : 2017-08-09T13:49:27.260Z
         * source : web
         * type : Android
         * url : http://www.jianshu.com/p/d054760c2477
         * used : true
         * who : drawthink
         * images : ["http://img.gank.io/ea71986c-4e0f-4b21-97a5-06dc311fff0b"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
