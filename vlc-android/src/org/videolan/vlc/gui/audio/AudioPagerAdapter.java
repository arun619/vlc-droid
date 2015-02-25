/*
 * *************************************************************************
 *  AudioPagerAdapter.java
 * **************************************************************************
 *  Copyright © 2015 VLC authors and VideoLAN
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 *  ***************************************************************************
 */

package org.videolan.vlc.gui.audio;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.videolan.vlc.R;

import java.util.ArrayList;

public class AudioPagerAdapter extends PagerAdapter {

    private ArrayList<ListView> mLists;

    public AudioPagerAdapter(ArrayList<ListView> lists){
        mLists = lists;
    }

    @Override
    public int getCount() {
        return mLists == null ? 0 : mLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View page = mLists.get(position);
        container.addView(page);
        return page;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mLists.remove(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Context context = mLists.get(0).getContext();
        switch (position){
            case AudioBrowserFragment.MODE_ARTIST:
                return context.getString(R.string.artists);
            case AudioBrowserFragment.MODE_ALBUM:
                return context.getString(R.string.albums);
            case AudioBrowserFragment.MODE_SONG:
                return context.getString(R.string.songs);
            case AudioBrowserFragment.MODE_GENRE:
                return context.getString(R.string.genres);
            default:
                return "";
        }
    }
}