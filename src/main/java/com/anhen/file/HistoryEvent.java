package com.anhen.file;

import lombok.Data;

@Data
public class HistoryEvent {
    /** 类型 */
    private int id;

    /** 数量 */
    private String time;

    /** 历史事件 **/
    private String content;

    /** 链接 **/
    private String url;

    public HistoryEvent(int id, String time, String content, String url) {
        this.id = id;
        this.time = time;
        this.content = content;
        this.url = url;
    }
}