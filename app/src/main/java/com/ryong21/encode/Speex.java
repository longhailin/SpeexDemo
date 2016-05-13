
package com.ryong21.encode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Speex {

    /* quality
     * 1 : 4kbps (very noticeable artifacts, usually intelligible)
     * 2 : 6kbps (very noticeable artifacts, good intelligibility)
     * 4 : 8kbps (noticeable artifacts sometimes)
     * 6 : 11kpbs (artifacts usually only noticeable with headphones)
     * 8 : 15kbps (artifacts not usually noticeable)
     */
    private static final int DEFAULT_COMPRESSION = 8;
    private Logger log = LoggerFactory.getLogger(Speex.class);

    static {
        System.loadLibrary("speex");
    }

    Speex() {
    }

    public void init() {
        load();
        open(DEFAULT_COMPRESSION);
        log.error("speex opened");

    }

    private void load() {
        try {

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public native int open(int compression);

    public native int getFrameSize();

    public native int decode(byte encoded[], short lin[], int size);

    public native int encode(short lin[], int offset, byte encoded[], int size);

    public native void close();

}