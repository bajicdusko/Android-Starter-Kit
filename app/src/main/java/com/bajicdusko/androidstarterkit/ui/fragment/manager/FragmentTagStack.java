package com.bajicdusko.androidstarterkit.ui.fragment.manager;

import android.text.TextUtils;
import android.util.Log;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;
import org.parceler.Transient;

import java.util.LinkedList;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 22.05.17.
 */

@Parcel(Parcel.Serialization.BEAN)
public class FragmentTagStack {

    @Transient private static final String TAG = "FragmentTagStack";

    @Transient private boolean showLogs;

    private LinkedList<String> tags;
    private String activeTag;

    FragmentTagStack() {
        tags = new LinkedList<>();
        activeTag = null;
    }

    @ParcelConstructor
    public FragmentTagStack(LinkedList<String> tags, String activeTag) {
        this.tags = tags;
        this.activeTag = activeTag;
    }

    public LinkedList<String> getTags() {
        return tags;
    }

    /**
     * Getter for {@link FragmentTagStack#activeTag}
     *
     * @return {@link FragmentTagStack#activeTag}
     */
    public String getActiveTag() {
        return activeTag;
    }

    /**
     * Enabling or disabling fragment stack logs. Logs are disabled by default.
     *
     * @param showLogs
     */
    public void setShowLogs(boolean showLogs) {
        this.showLogs = showLogs;
    }

    /**
     * Pushing new tag to stack and setting is as {@link FragmentTagStack#activeTag}
     *
     * @param tag
     */
    void push(String tag) {
        tags.add(tag);
        activeTag = tag;
        logStack();
    }

    /**
     * Popping tag from the stack and setting the tag below as new {@link FragmentTagStack#activeTag}
     * <p>
     * Example:
     * <p>
     * Stack [3, 2, 1, 0] (3 is last added tag). {@link FragmentTagStack#activeTag} have value 3
     * <p>
     * Now we're popping the last added tag
     * <p>
     * Stack [2, 1, 0] {@link FragmentTagStack#activeTag} have value 2
     *
     * @return Popped up value. From the example above, returned value will be 3. In case of empty stack, null will be returned.
     */
    String pop() {
        String tag = peek();
        if (!TextUtils.isEmpty(tag)) {
            tags.remove(tags.size() - 1);
        }

        activeTag = peek();
        logStack();
        return tag;
    }

    /**
     * Peeking to the top of the stack, without data modification.
     *
     * @return Value on top of the stack. If stack is empty, returned value will be null.
     */
    String peek() {
        if (tags.size() > 0) {
            return tags.get(tags.size() - 1);
        } else {
            return null;
        }
    }

    private void logStack() {
        if (showLogs) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Active tag: " + activeTag + "\nStack:\n");
            for (int i = tags.size() - 1; i >= 0; i--) {
                stringBuilder.append("[" + tags.get(i) + "]\n");
            }
            Log.d(TAG, stringBuilder.toString());
        }
    }

    /**
     * Clears the stack.
     */
    void popUpAll() {
        tags.clear();
    }
}
