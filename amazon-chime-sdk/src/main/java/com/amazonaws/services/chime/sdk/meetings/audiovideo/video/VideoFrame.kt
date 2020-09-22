package com.amazonaws.services.chime.sdk.meetings.audiovideo.video


class VideoFrame(
    /**
     * Width of the video frame
     */
    val width: Int,

    /**
     * Height of the video frame
     */
    val height: Int,

    /**
     * Timestamp at which the video frame was captured
     */
    val timestamp: Long,

    /**
     * Object containing actual video frame data in some form
     */
    val buffer: VideoFrameBuffer,

    /**
     * Rotation of the video frame buffer in degrees
     */
    val rotation: Int = 0
) {
    /**
     * Width of frame when rotation is removed
     *
     * @return [Int] - Frame width when rotation is removed
     */
    fun getRotatedWidth(): Int {
        return if (rotation % 180 == 0) {
            buffer.width
        } else buffer.height
    }

    /**
     * Height of frame when rotation is removed
     *
     * @return [Int] - Frame height when rotation is removed
     */
    fun getRotatedHeight(): Int {
        return if (rotation % 180 == 0) {
            buffer.height
        } else buffer.width
    }

    /**
     * Helper function to call retain on the owned buffer
     */
    fun retain() {
        buffer.retain()
    }

    /**
     * Helper function to call release on the owned buffer
     */
    fun release() {
        buffer.release()
    }
}