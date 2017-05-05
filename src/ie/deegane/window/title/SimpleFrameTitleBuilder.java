package ie.deegane.window.title;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.impl.FrameTitleBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * Switch project and file name order
 */
public class SimpleFrameTitleBuilder extends FrameTitleBuilder {
    private static FrameTitleBuilder defaultBuilder;

    public static void setDefaultBuilder(FrameTitleBuilder defaultBuilder) {
        SimpleFrameTitleBuilder.defaultBuilder = defaultBuilder;
    }

    @Override
    public String getProjectTitle(@NotNull Project project) {
        return "";
    }

    @Override
    public String getFileTitle(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        String projectFullTitle = defaultBuilder.getProjectTitle(project);
        String projectTitle = projectFullTitle.substring(0,projectFullTitle.indexOf("["));
        return projectTitle + defaultBuilder.getFileTitle(project,virtualFile).replaceAll("-","");
    }
}
