package ir.saltech.answersheet.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eightbitlab.com.blurview.BlurView;
import ir.saltech.answersheet.R;
import ir.saltech.answersheet.object.container.Saver;
import ir.saltech.answersheet.object.data.Exam;
import ir.saltech.answersheet.object.data.ExamWallpaper;
import ir.saltech.answersheet.object.data.ExamWallpapers;
import ir.saltech.answersheet.object.enums.WallpaperType;
import ir.saltech.answersheet.view.activity.MainActivity;
import ir.saltech.answersheet.view.adapter.WallpapersViewAdapter;
import ir.saltech.answersheet.view.container.BlurViewHolder;
import ir.saltech.answersheet.view.container.Toast;

public class SetWallpaperFragment extends Fragment {

    private BlurView parent;
    private RecyclerView picturesLayout;
    private RecyclerView animationsLayout;
    private List<ExamWallpaper> wallpapers;
    private WallpapersViewAdapter picturesAdapter;
    private WallpapersViewAdapter animationsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_set_wallpaper, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        MainActivity.setStatusBarTheme(requireActivity(), !MainActivity.checkDarkModeEnabled(requireContext()));
        BlurViewHolder.setBlurView(requireActivity(), parent);
        setupLayouts();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setupLayouts() {
        wallpapers = Saver.getInstance(requireContext()).loadExamWallpapers().getWallpapers();
        List<ExamWallpaper> pictureWallpapers = getWantedWallpapers(WallpaperType.Picture);
        List<ExamWallpaper> animationWallpapers = getWantedWallpapers(WallpaperType.Animation);
        picturesAdapter = new WallpapersViewAdapter(pictureWallpapers, (wallpaper, position) -> {
            setupThisWallpaper(wallpaper, position);
            Toast.makeText(requireContext(), "تصویر زمینه تصویری اعمال شد.", Toast.WARNING_SIGN, Toast.LENGTH_SHORT).show();
        });
        animationsAdapter = new WallpapersViewAdapter(animationWallpapers, (wallpaper, position) -> {
            setupThisWallpaper(wallpaper, position);
            Toast.makeText(requireContext(), "تصویر زمینه متحرک اعمال شد.", Toast.WARNING_SIGN, Toast.LENGTH_SHORT).show();
        });
        picturesLayout.setLayoutManager(new GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false));
        picturesLayout.setAdapter(picturesAdapter);
        animationsLayout.setLayoutManager(new GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false));
        animationsLayout.setAdapter(animationsAdapter);
        if (picturesAdapter != null) {
            picturesAdapter.notifyDataSetChanged();
        }
        if (animationsAdapter != null) {
            animationsAdapter.notifyDataSetChanged();
        }
    }

    @SuppressLint({"NotifyDataSetChanged", "UseCompatLoadingForDrawables"})
    private void setupThisWallpaper(ExamWallpaper wallpaper, int position) {
        ExamWallpapers examWallpapers = new ExamWallpapers();
        if (wallpaper.getType() == WallpaperType.Picture) {
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, position == 0));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, position == 1));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, position == 2));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, position == 3));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, position == 4));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, position == 5));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, false));
        } else if (wallpaper.getType() == WallpaperType.Animation) {
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Picture, false));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, position == 0));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, position == 1));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, position == 2));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, position == 3));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, position == 4));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, position == 5));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, position == 6));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, position == 7));
            examWallpapers.addWallpaper(new ExamWallpaper(WallpaperType.Animation, position == 8));
        }
        Saver.getInstance(requireContext()).saveExamWallpapers(examWallpapers);
        setupLayouts();
    }

    private List<ExamWallpaper> getWantedWallpapers(WallpaperType type) {
        List<ExamWallpaper> filteredWallpapers = new ArrayList<>();
        for (ExamWallpaper wallpaper : wallpapers) {
            if (wallpaper.getType() == type) {
                filteredWallpapers.add(wallpaper);
            }
        }
        return filteredWallpapers;
    }

    private void init(@NonNull View v) {
        parent = v.findViewById(R.id.background_picker_parent);
        picturesLayout = v.findViewById(R.id.pictures_background);
        animationsLayout = v.findViewById(R.id.animations_background);
    }
}
