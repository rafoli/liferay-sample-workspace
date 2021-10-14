export function useRoles() {
    const isAdmin = SampleWorkspace.isAdmin 
    const isUser = SampleWorkspace.isUser
    const isSignedIn = Liferay.ThemeDisplay.isSignedIn();
 
    return [
        isAdmin,
        isUser,
        isSignedIn
    ]
}