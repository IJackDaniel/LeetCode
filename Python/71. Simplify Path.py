# 71. Simplify Path
# Date of problem solution: 21.01.2025

class Solution:
    def simplifyPath(self, path: str) -> str:

        while "//" in path:
            path = path.replace("//", "/")
        arr = [i for i in path.split("/") if i]

        stack = []
        for file in arr:
            if file == ".":
                continue
            elif file == "..":
                if stack:
                    stack.pop()
            else:
                stack.append(file)
        stack = stack[::-1]

        res_path = "/"
        while stack:
            res_path += str(stack.pop())
            if stack:
                res_path += "/"
        return res_path


sl = Solution()
print(sl.simplifyPath("/home/"))
print(sl.simplifyPath("/home//foo/"))
print(sl.simplifyPath("/home/user/Documents/../Pictures"))
print(sl.simplifyPath("/../"))
print(sl.simplifyPath("/.../a/../b/c/../d/./"))
# sl.simplifyPath()


### Вот этот код лучший по времени:
#
# class Solution:
#     def simplifyPath(self, path: str) -> str:
#
#         while "//" in path:
#             path = path.replace("//", "/")
#         arr = [i for i in path.split("/") if i]
#
#         stack = []
#         for file in arr:
#             if file == ".":
#                 continue
#             elif file == "..":
#                 if stack:
#                     stack.pop()
#             else:
#                 stack.append(file)
#         stack = stack[::-1]
#
#         res_path = "/"
#         while stack:
#             res_path += str(stack.pop())
#             if stack:
#                 res_path += "/"
#         return res_path
