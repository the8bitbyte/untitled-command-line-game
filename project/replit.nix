{ pkgs }: {
    deps = [
      pkgs.w3m
      pkgs.dpkg
      pkgs.xfce.thunar
      pkgs.terminator
      pkgs.vim
      pkgs.unzip
      pkgs.firefox
      pkgs.neofetch
      pkgs.nano
      pkgs.iproute
        pkgs.graalvm17-ce
        pkgs.maven
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
    ];
}